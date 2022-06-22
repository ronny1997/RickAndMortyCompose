package com.ronny.presentation.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ronny.core.base.BaseCompose
import com.ronny.core.navigation.Screen
import com.ronny.presentation.authentication.components.PortalAnimation

@Composable
fun LoginView(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var portalAnimate by remember { mutableStateOf(false) }

    BaseCompose(LocalLifecycleOwner.current, viewModel) { state ->
        when (state) {
            is LoginViewState.InitState -> {
                portalAnimate = true
            }
            is LoginViewState.SuccessLogin -> {
                portalAnimate = false
                navController.navigate(Screen.Home.route)
            }
        }
    }
    viewModel.onEvent(LoginViewEvent.Initialize)

    Scaffold {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val (email, setTextEmail) = remember { mutableStateOf("") }
            val (pass, setTexPass) = remember { mutableStateOf("") }

            val keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            val focusRequester = remember { FocusRequester() }
            var passwordVisibility by remember { mutableStateOf(false) }

            val modifier = Modifier
                .padding(horizontal = 26.dp)
                .padding(bottom = 5.dp, top = 5.dp)
                .fillMaxWidth()

            PortalAnimation(portalAnimate)

            TextField(
                value = email,
                onValueChange = setTextEmail,
                maxLines = 1,
                label = { Text("Email") },
                placeholder = { Text("Email") },
                modifier = modifier,
                keyboardOptions = keyboardOptions,
                keyboardActions = KeyboardActions(
                    onNext = { focusRequester.requestFocus() }
                )
            )
            TextField(
                value = pass,
                onValueChange = setTexPass,
                maxLines = 1,
                label = { Text("Password") },
                placeholder = { Text("Password") },
                modifier = modifier
                    .focusRequester(focusRequester = focusRequester),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        if (passwordVisibility) Icon(
                            imageVector = Icons.Default.Visibility,
                            contentDescription = "Pass VisibilityOn"
                        ) else Icon(
                            imageVector = Icons.Default.VisibilityOff,
                            contentDescription = "Pass VisibilityOn"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            )

            Button(
                modifier = modifier,
                onClick = {
                    viewModel.onEvent(LoginViewEvent.Authenticate(email, pass))
                }
            ) {
                Text("LOGIN")
            }
        }
    }
}


@Preview
@Composable
fun LoginViewPreview() = LoginView(rememberNavController())