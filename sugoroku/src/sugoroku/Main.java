package sugoroku;

import java.util.Random;
import java.util.Scanner;

/**
 * すごろくチャレンジ！
 * @author med
 */
public class Main {

	/**
	 * すごろくインスタンスで使用する 乱数発生装置
	 */
	private Random rand = new Random();
	/**
	 * すごろくインスタンスで使用する 入力装置
	 */
	private Scanner input = new Scanner(System.in);
	/**
	 * すごろくのマス目配列
	 */
	private Cell[] path;
	/**
	 * ゲーム参加者のコマ
	 */
	private Coma[] players;
	
	
	
	/**
	 * すごろくのメインプログラム
	 * @param args 起動時引数
	 */
	public static void main(String[] args) {
		new Main().run();
	}
	/**
	 * すごろくプログラムの動作
	 */
	private void run() {
		initGame();
		
		// ターンを繰り返し
		boolean goal = false;
		do {
			showPath();	
			
			for( int i = 0; i < players.length; i++ ) {
				Coma coma = players[i];
				
				playTurn( coma );
				actionCell( coma );
				goal = checkGoal( coma );
				if( goal ) {
					break; // for 文処理中断
				}
			}			
		} while(!goal);
		
		exitGame();
	}
	/**
	 * 指定されたコマが ゴールしたかを判定します
	 * @param coma 判定対象のコマ
	 * @return ゴールした場合 true
	 */
	private boolean checkGoal(Coma coma) {
		boolean goal = path.length - 1 <= coma.getPosition();
		if( goal ) {
			System.out.println("ゴールやで");
			return true;
		}
		return false;
	}
	/**
	 * 現在のマスに割り振られたイベントを発動させます
	 * @param coma 対象となるコマ
	 */
	private void actionCell(Coma coma) {
		int pos = coma.getPosition();
		if( pos < path.length ) {
			Cell now = path[pos];
			// どんなマスに来たのか情報を出す
			System.out.println( now.getCaption() );
			// マスに割りふられたイベントが 発動する
			now.doEvent(coma);
			coma.showProfile();
		}		
	}
	/**
	 * ゲームを進行させます
	 * @param coma 対象となるコマ
	 */
	private void playTurn(Coma coma) {
		if( !coma.isAuto() ) {
			if( coma.hasItems() ) {
				coma.showItems();
				System.out.println("アイテムを使用する場合は 番号を入力してね");
				try {
					String s = input.nextLine();
					int id = Integer.parseInt(s);
					
					coma.useItem(id, coma);
					showPath();
					
				}catch( Exception e) {
					input.nextLine();
				}
			}
			System.out.println("ダイス振ってね(エンターキー入力！)");
			input.nextLine();	//入力待ち(データは読み取らない)
		}
		
		int proceed = rand.nextInt(4) + 1; // 1~4 のどれか適当に
		System.out.println( proceed + "がでたよ");
		
		// コマを出目分進める
		coma.proceed(proceed);		
	}
	/**
	 * 現状のすごろく状態を表示する
	 */
	private void showPath() {
		// マス目番号を表示
		System.out.print("  ");
		for (int i = 0; i < path.length; i++) {
			if( i < 10 ) {
				System.out.print( " " );
			}
			System.out.print( i + " " );
		}
		System.out.println();// 改行
		
		// マス目のイメージを表示
		System.out.print("  ");
		for (int i = 0; i < path.length; i++) {
			System.out.print( " " + path[i].getMark() + " " );
		}
		System.out.println();// 改行

		
		// プレイヤー位置を表示
		for( int i = 0; i < players.length; i++ ) {
			showComaPos( i );
		}

	}
	/**
	 * コマの位置を表示します
	 * @param pid
	 */
	private void showComaPos(int pid ) {
		Coma coma = players[pid];
		System.out.print( pid + ":" );
		for (int i = 0; i < path.length; i++) {
			if( i != coma.getPosition() ) {
				System.out.print( "   " );
			}else {
				System.out.print( " * " );
			}
		}
		System.out.println();// 改行
	}
	/**
	 * ゲームが終わった時の処理
	 */
	private void exitGame() {
		System.out.println("--------最終結果--------");
		showPath();
	}
	/**
	 * ゲームを始めるための 下準備
	 */
	private void initGame() {
		// すごろくフィールド
		path = new Cell[] {
			new StartCell(),
			new NormalCell(),
			new ReturnCell(2),
			new PresentCell(),
			new PresentCell(),
			new NormalCell(),
			new ReturnCell(4),
			new ReturnCell(3),
			new NormalCell(),
			new ReturnCell(1),
			new NormalCell(),
			new ReturnCell(2),
			new NormalCell(),
			new ReturnCell(2),
			new NormalCell(),
			new PresentCell(),
			new NormalCell(),
			new NormalCell(),
			new ReturnCell(1),
			new ReturnCell(2),
			new ReturnCell(3),
			new GoalCell(),
		};
		
		players = new Coma[] {
				new UserComa("( *´艸｀)"),
				new NPCComa(),
				new NPCComa(),
				new NPCComa(),
		};
		System.out.println( path[0].getCaption() );
	}

}
