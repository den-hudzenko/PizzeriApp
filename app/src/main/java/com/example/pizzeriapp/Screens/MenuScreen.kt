package com.example.pizzerapp.Screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pizzeriapp.AppViewModelProvider
import com.example.pizzeriapp.Database.GoodItem
import com.example.pizzeriapp.Hardcoded.Another
import com.example.pizzeriapp.Hardcoded.Model
import com.example.pizzeriapp.Hardcoded.Pizza
import com.example.pizzeriapp.Hardcoded.Rolls
import com.example.pizzeriapp.Hardcoded.Sets
import com.example.pizzeriapp.R
import com.example.pizzeriapp.ViewModel.DBViewModel

@Composable
fun MenuScreen(viewModel: DBViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    var currentCategory by remember { mutableStateOf("Суші") }

    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()
    ) {

            val allItems: List<Model> = Rolls + Pizza + Sets + Another
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)) {
                item {
                    Box {


                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(18.dp)
                        ) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.logo),
                                    contentDescription = "logo"
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Row {
                                    Image(
                                        painter = painterResource(R.drawable.baseline_location_on_24),
                                        contentDescription = "location"
                                    )
                                    Text(text = "Lviv", fontSize = 20.sp, color = Color.White)
                                }
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ad1),
                                    contentDescription = "ad 1",
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(100.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.ad2),
                                    contentDescription = "ad 2",
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(100.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.ad3),
                                    contentDescription = "ad 3",
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(100.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(5.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Button(
                                    onClick = { currentCategory = "Суші" },
                                    colors = ButtonDefaults.buttonColors(Color.Magenta),
                                    modifier = Modifier.padding(3.dp)
                                ) {
                                    Text(text = "Суші")
                                }
                                Button(
                                    onClick = { currentCategory = "Піца" },
                                    colors = ButtonDefaults.buttonColors(Color.Magenta),
                                    modifier = Modifier.padding(3.dp)
                                ) {
                                    Text(text = "Піца")
                                }
                                Button(
                                    onClick = { currentCategory = "Сети" },
                                    colors = ButtonDefaults.buttonColors(Color.Magenta),
                                    modifier = Modifier.padding(3.dp)
                                ) {
                                    Text(text = "Сети")
                                }
                                Button(
                                    onClick = { currentCategory = "Інше" },
                                    colors = ButtonDefaults.buttonColors(Color.Magenta),
                                    modifier = Modifier.padding(3.dp)
                                ) {
                                    Text(text = "Інше")
                                }
                            }
                        }
                    }


                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(600.dp) // Set a specific height here
                    ) {
                        LazyVerticalStaggeredGrid(
                            modifier = Modifier.fillMaxSize(), // Consume all available space
                            columns = StaggeredGridCells.Fixed(2),
                            verticalItemSpacing = 4.dp,
                            horizontalArrangement = Arrangement.Center,
                        ) {

                            items(allItems.filter { it.category == currentCategory }) { item ->
                                ItemCard(item = item, viewModel)
                            }
                        }
                    }
                }
            }


    }
}

@Composable
fun ItemCard(item : Model, viewModel: DBViewModel){
    val context = LocalContext.current
    Box(
        Modifier
            .requiredWidth(160.dp)
            .height(420.dp)){
        Card(modifier = Modifier.background(Color.Black),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black,
            )){
            Column {
                Box {
                    if(item.isNew) {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Magenta,
                            ), modifier = Modifier.padding(start = 10.dp)
                        ) {
                            Text(
                                text = "NEW",
                                fontSize = 10.sp,
                                color = Color.White,
                                modifier = Modifier.padding(
                                    start = 10.dp,
                                    end = 10.dp,
                                    top = 3.dp,
                                    bottom = 3.dp
                                )
                            )
                        }
                    }
                    Image(painter = painterResource(id = item.image), contentDescription = item.title, modifier = Modifier.size(180.dp))

                }
                Text(text = item.title, fontSize = 20.sp, color = Color.White)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = item.description, fontSize = 15.sp, color = Color.White)
                Spacer(modifier = Modifier.height(5.dp))

                Text(text = item.weight.toString() + " г", fontSize = 13.sp, color = Color.White)
                Spacer(modifier = Modifier.height(10.dp))

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = item.price.toString() + " ₴", fontSize = 20.sp, color = Color.White)
                    Spacer(modifier = Modifier.weight(1f))
                    Button(onClick = {
                        Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show()
                        viewModel.insert(item = GoodItem(title = item.title, description = item.description, image = item.image, price = item.price, weight = item.weight,  isNew = item.isNew, quantity = 1))
                                     }, colors = ButtonDefaults.buttonColors(Color.Magenta)) {
                        Text(text = "Хочу", modifier = Modifier.padding(3.dp))

                    }
                }

            }
        }
    }
}

