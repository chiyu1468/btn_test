package tw.org.iii.btn_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);

        initCheckerBoard();

    }

    // X -> +1
    // O -> -1

    // 初始化棋盤
    int turn;
    int[] wholeCheckBoard;
    private void initCheckerBoard(){
        tv.setText("ReStart!!!");

        turn = +1;
        // 清空盤面 - 畫面
        int[] chessAll = {  R.id.ButtonOne,R.id.ButtonTwo,R.id.ButtonThree,
                            R.id.ButtonFour,R.id.ButtonFive, R.id.ButtonSix,
                            R.id.ButtonSeven,R.id.ButtonEight,R.id.ButtonNine};
        for(int buttonID : chessAll){
            Button button = (Button) findViewById(buttonID);
            button.setText("");
        }
        // 清空盤面 - 內存
        wholeCheckBoard = new int[] {9, 0,0,0, 0,0,0, 0,0,0};

    }

    public void start(View v){
        initCheckerBoard();
    }

    public void ChessClick(View v) {
        // 所有按鍵統一呼叫這個方法
        // 然後在直接用 getId 區別按鍵
        change(v.getId());
    }

    private void change(int buttonID){
        Button button = (Button) findViewById(buttonID);
        // 用 Tag 判斷按下的鍵 並轉成數字
        int i = Integer.parseInt(button.getTag().toString());
        Log.v("chiyu","Press : " + i);

        // 下子
        if(button.getText().equals("")){
            switch (turn){
                case 1:
                    button.setText("X");
                    break;
                case -1:
                    button.setText("O");
                    break;
            }
            judge(i);
            turn *= -1;
        }
    }


    private int judge(int ButtonNo){

        Boolean isWin = false;
        wholeCheckBoard[ButtonNo] = turn;

        // 判斷輸贏核心
        if(ButtonNo%2 == 0){ // case 2,4,6,8
            int j = ButtonNo;
            for(int i=1;i<=3;i++){
                j += 2; if( j > 8 ) j -= 8;
                if(wholeCheckBoard[j] == turn && wholeCheckBoard[15-ButtonNo-j] == turn){
                    isWin = true; break;
                }
            }
        } else if(ButtonNo == 5){ // case 5
            for(int i=1;i<=4;i++){
                if(wholeCheckBoard[i] == turn && wholeCheckBoard[15-ButtonNo-i] == turn){
                    isWin = true; break;
                }
            }
        } else if(ButtonNo > 5 ){ // case 7 9
            if(wholeCheckBoard[5] == turn && wholeCheckBoard[10-ButtonNo] == turn){
                isWin = true;
            }
            if(wholeCheckBoard[2] == turn && wholeCheckBoard[15-2-ButtonNo] == turn){
                isWin = true;
            }
        } else if(ButtonNo < 5 ){ // case 1 3
            if(wholeCheckBoard[5] == turn && wholeCheckBoard[10-ButtonNo] == turn){
                isWin = true;
            }
            if(wholeCheckBoard[8] == turn && wholeCheckBoard[15-8-ButtonNo] == turn){
                isWin = true;
            }
        }

        if(isWin) tv.setText((turn>0?"X":"O") + " is Winner!!!");

        return 0;
    }


//          private Button ButtonOne,ButtonTwo,ButtonThree,ButtonFour,ButtonFive,ButtonSix,ButtonSeven,ButtonEight,ButtonNine;
//          private String[] chessNo = {"None","ButtonOne","ButtonTwo","ButtonThree","ButtonFour","ButtonFive","ButtonSix","ButtonSeven","ButtonEight","ButtonNine"};
//        ButtonOne = (Button) findViewById(R.id.ButtonOne);
//        ButtonTwo = (Button) findViewById(R.id.ButtonTwo);
//        ButtonThree = (Button) findViewById(R.id.ButtonThree);
//        ButtonFour = (Button) findViewById(R.id.ButtonFour);
//        ButtonFive = (Button) findViewById(R.id.ButtonFive);
//        ButtonSix = (Button) findViewById(R.id.ButtonSix);
//        ButtonSeven = (Button) findViewById(R.id.ButtonSeven);
//        ButtonEight = (Button) findViewById(R.id.ButtonEight);
//        ButtonNine = (Button) findViewById(R.id.ButtonNine);
}
