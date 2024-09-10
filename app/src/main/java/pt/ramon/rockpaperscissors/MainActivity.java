package pt.ramon.rockpaperscissors;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selectRock( View view ){
        verifyResult("ROCK");
    }

    public void selectPaper( View view ){
        verifyResult("PAPER");
    }

    public void selectScissors( View view ){
        verifyResult("SCISSORS");
    }

    private String randomChoiceApp() {
        String[] choices = {"ROCK", "PAPER", "SCISSORS"};
        int randomIndex = (int) (Math.random() * choices.length);

        ImageView imageApp = findViewById(R.id.choiceApp);
        String appChoice = choices[randomIndex];
        switch ( appChoice ){
            case "ROCK":
                imageApp.setImageResource(R.drawable.rock);
                break;
            case "PAPER":
                imageApp.setImageResource(R.drawable.paper);
                break;
            case "SCISSORS":
                imageApp.setImageResource(R.drawable.scissors);
                break;
        }

        return appChoice;
    }

    private void verifyResult(String userChoice){
        String appChoice = randomChoiceApp();
        TextView textResult = findViewById(R.id.text_result);

        if(
            (appChoice == "ROCK" && userChoice == "SCISSORS") || (appChoice == "PAPER" && userChoice == "ROCK") || (appChoice == "SCISSORS" && userChoice == "PAPER")
        ){
            textResult.setText("YOU LOSE :(");
        }else if(
            (userChoice == "ROCK" && appChoice == "SCISSORS") || (userChoice == "PAPER" && appChoice == "ROCK") || (userChoice == "SCISSORS" && appChoice == "PAPER")
        ){
            textResult.setText("YOU WIN :)");
        }else{
            textResult.setText("DRAW");
        }
    }

}