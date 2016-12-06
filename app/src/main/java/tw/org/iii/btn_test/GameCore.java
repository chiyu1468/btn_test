package tw.org.iii.btn_test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 遊戲核心
 * - checkerboard
 *     -> 屬性： 回合數  各方格棋子堆疊  棋步紀錄
 *     -> 方法： 初始化  下子push  提子pop  棋步紀錄
 * - piece
 *     -> 屬性： 大小  陣營  ID
 *     -> 方法： 移動  is移動合法  here
 * - player
 *     -> 屬性： 陣營
 *     -> 方法： 出新棋  移動舊棋  投降
 * - gameLibrary
 *     -> 屬性： player  is開始  is結束  誰的回合
 *     -> 方法： 判斷勝負  判斷重複  創造新棋(及判斷剩餘棋)  分配陣營
 *
 */


// All config define in GameCore
public class GameCore {

    // 棋盤大小
    static final byte BoardHeight = 3;
    static final byte BoardWidth = 3;

    // 遊戲人數
    static final byte maxPlayerNum = 2;
    static final byte minPlayerNum = 2;

    // 棋子的種類
    static class PieceSize {
        String[] sizeName = {"null","Large","Middle","Small"};

        byte size = 0;
        PieceSize(byte size) {this.size = size;}
        String getSizeName() {return sizeName[this.size];}
    }

    // 陣營的種類
    static class Faction {
        String[] factionName = {"null","Blue","Orange"};

        byte faction = 0;
        Faction(byte faction) {this.faction = faction;}
        String getFactionName() {return factionName[this.faction];}
        }



    }

class checkerboard {
    // 目前遊戲回合數
    private int passedTurns;

    // 棋盤面 = 方格 ＋ 棋子堆疊
    // 用 整數 對方格編號
    // 用 LinkedList<piece> 紀錄目前有哪些棋子 在這個方格
    private HashMap<Integer, LinkedList<piece>> boardGrids;



    // 初始化
    void boardInitail() {
        passedTurns = 0;
        for(int counter = 0; counter < (GameCore.BoardWidth * GameCore.BoardHeight) ; counter++) {
        // TODO 這邊做初始化動作

        }
    }


    // 棋步紀錄
    // LinkedList<回合數,陣營,>
    private LinkedList<Integer,GameCore.Faction,Integer,Integer> gameRecode;

}

class piece {
    // 棋子大小
    private GameCore.PieceSize size;
    // 棋子陣營
    private GameCore.Faction faction;

    // 檢查這一步 能不能走
    boolean canMove() {

        return false;
    }

    void Move() {

    }

    void Here() {

    }

}

class player {
    // 陣營
    private GameCore.Faction faction;

    // 出新棋
    private void placeNewPiece() {

    }

    // 移動舊棋
    private void moveOnBoardPiece() {

    }

    //不玩了 投降
    private void surrender() {

    }
}

class gameReferee {
    // 目前遊戲狀態
    private boolean isStart, isEnd;
    //
    private GameCore.Faction whosTurn;
    //
    private LinkedList<player> players;

    //
    public void judge() {

    }

    //
    public void isRepeat() {

    }

    public void isRemain() {

    }

}
