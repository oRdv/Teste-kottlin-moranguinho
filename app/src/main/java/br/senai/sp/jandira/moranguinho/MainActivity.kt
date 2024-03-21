package br.senai.sp.jandira.moranguinho

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalFlorist
import androidx.compose.material.icons.filled.ScubaDiving
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.moranguinho.ui.theme.MoranguinhoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoranguinhoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    Image(
        painter = painterResource(id = R.drawable.fundomg),
        contentDescription = "Background morangos",
        contentScale = ContentScale.Crop
    )

    Column (
        modifier = Modifier.padding(10.dp)
    ){
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            shape = CircleShape,
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.LocalFlorist, contentDescription = "Botão de busca",
                        tint = Color(0xFFCB254F)
                    )
                }
            },
            placeholder = {
                Text(
                    text = "Buscar Personagens",
                    color = Color(0xFFD10337),
                    fontWeight = FontWeight.Bold

                )
            },

            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFC54F6C),
                focusedBorderColor = Color(0xFFD2496C)
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Lista de Personagens",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFFAB012B),
            fontFamily = FontFamily.SansSerif
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ){
            items(100){
               Card (
                   modifier = Modifier
                       .fillMaxWidth()
                       .height(150.dp)
                       .padding(bottom = 8.dp),
                   colors = CardDefaults.cardColors(containerColor = Color(0xBFFFFFFF))
               ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                        
                    ) {
                        Card (
                                modifier = Modifier.size(width = 100.dp, height = 100.dp),
                            shape = CircleShape
                        ) {
                            Image(painter = painterResource
                                (id = R.drawable.moranguinhom),
                                contentDescription = "foto moranguinho",
                                contentScale = ContentScale.Crop
                            )
                        }

                        Column (
                            modifier = Modifier.padding(start = 16.dp)
                        ){
                            Text(
                                text = "Moranguinho",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFD2335A),
                                letterSpacing = 6.sp
                            )

                            Text(
                                text = "Moranguinho é um trabalhadora que executa o Café Tutti Frutti e recebe um monte de coisas ao redor da cidade. ",
                                fontSize = 14.sp,
                                color = Color(0xFF000000),
                                lineHeight = 20.sp
                            )
                        }
                    }

               }
            }
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MoranguinhoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting()
        }
    }
}