package com.example.hw2_potato.model

import androidx.compose.runtime.MutableState

data class CheckState(val name: String,val resId: Int,val state: MutableState<Boolean>)
