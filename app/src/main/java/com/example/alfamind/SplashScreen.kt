package com.example.alfamind

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashContent()
        }

        val splashTimeOut = 3000L
        Thread(Runnable {
            try {
                Thread.sleep(splashTimeOut)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } finally {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        }).start()
    }

    @Composable
    fun SplashContent() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFCD3437)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFCD3437)), // Warna latar belakang CD3437
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo), // Ganti dengan ID drawable logo Anda
                    contentDescription = null,
                    modifier = Modifier.size(224.dp), // Ubah ukuran gambar sesuai kebutuhan
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}
