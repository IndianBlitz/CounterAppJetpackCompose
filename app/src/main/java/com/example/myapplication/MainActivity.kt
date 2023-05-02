package com.example.myapplication

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()

        }
    }
}




@Composable
fun MainScreen(){ //Hold Ui for main Screen
        val (counter,setCounter) = rememberSaveable {
            mutableStateOf<Int>(0)
        }


    Column(modifier = Modifier
        .background(color = Color.Black)
        .fillMaxSize()) {


        HeadingTxt()
        CounterText(num=counter)



        Row(modifier = Modifier.fillMaxWidth(1f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
            MinusBtn(onclick = { setCounter(counter - 1) })
            PlusBtn(onclick = { setCounter(counter + 1) })


        }





        Log.d("test",counter.toString())


    }

}

@Composable
fun HeadingTxt(){
    Text(text = "Counter App", color = Color.White, fontSize =40.sp, modifier = Modifier
        .fillMaxWidth(1f)
        .padding(bottom = 40.dp, top = 60.dp),textAlign = TextAlign.Center)
}



@Composable
fun PlusBtn(onclick: () -> Unit) {

    Button(onClick = onclick) {
        Text(text = "+", fontSize = 40.sp)
    }
}


@Composable
fun MinusBtn(onclick: () -> Unit,) {
    Button(onClick = onclick) {

        Text(text = "-", fontSize = 40.sp)
    }
}





@Composable
fun CounterText(num:Int){
    Text(text = num.toString(), color = Color.White, fontSize =300.sp, modifier = Modifier.fillMaxWidth(1f),textAlign = TextAlign.Center)
}










