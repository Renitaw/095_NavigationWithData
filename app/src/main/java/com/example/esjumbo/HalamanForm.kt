import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.esjumbo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClick: (MutableList<String>) -> Unit,
    onCancelButtonClick: () -> Unit,
) {
    var namaTxt by remember {
        mutableStateOf("")
    }
    var alamatTxt by remember {
        mutableStateOf("")
    }
    var telponTxt by remember {
        mutableStateOf("")
    }

    var ListDataTxt: MutableList<String> = mutableListOf(namaTxt, alamatTxt, telponTxt)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Data Pelanggan",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = namaTxt,
                onValueChange = { namaTxt = it },
                label = { Text(stringResource(id = R.string.namaTxt)) })

            OutlinedTextField(
                value = alamatTxt,
                onValueChange = { alamatTxt = it },
                label = { Text(stringResource(id = R.string.alamatTxt)) })

            OutlinedTextField(
                value = telponTxt,
                onValueChange = { telponTxt = it },
                label = { Text(stringResource(id = R.string.telponTxt)) })


            Spacer(modifier = Modifier.padding(16.dp))

            Row {
                Button(onClick = onCancelButtonClick) {
                    Text(text = stringResource(R.string.cancel))
                }

                Spacer(modifier = Modifier.padding(50.dp))

                Button(onClick = { onSubmitButtonClick(ListDataTxt) }) {
                    Text(text = stringResource(id = R.string.back))
                }
            }
        }
    }