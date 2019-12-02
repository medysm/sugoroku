/**
 * 
 */
package sugoroku;

import java.util.ArrayList;
import java.util.List;

/**
 * すごろくの プレイヤーと位置を表す コマクラス
 * @author med
 */
public abstract class Coma {
	/**
	 * プレイヤーの名前
	 */
	private String name;
	/**
	 * 現在位置
	 */
	private int position;
	/**
	 * ポイント
	 */
	private int point;
	/**
	 * 所持アイテム
	 */
	private List<Item> items = new ArrayList<>();
	
	/**
	 * コンストラクタ 
	 * @param name プレイヤー名
	 */
	public Coma( String name ) {
		this.name = name;
		this.position = 0;
	}
	/**
	 * 自動応答を行うか否か
	 * @return 行う場合 true
	 */
	public abstract boolean isAuto();
	/**
	 * このコマの現在位置を返します 
	 * @return 位置を表す数値
	 */
	public int getPosition() {
		return this.position;
	}
	/**
	 * このコマが 指定された分量 進みます
	 * @param amount すすむ量
	 */
	public void proceed(int amount) {
		this.position += amount;
	}
	/**
	 * ポイントがふえるよ！
	 * @param amount 増えるポイント数
	 */
	public void addPoint( int amount ) {
		System.out.println(name + " は " + amount + "ポイントをゲットした！"); 
		this.point += amount;
	}
	/**
	 * このコマの 現在の状態を表示します
	 */
	public void showProfile( ) {
		System.out.println( name 
					+ " の げんざいのぽいんとは " + point + " で、" 
					+ position + " コマ目にいます");
	}
	/**
	 * このコマの 所持品一覧を表示します
	 */
	public void showItems() {
		System.out.println("持ち物リスト -------");
		for (int i = 0; i < items.size(); i++) {
			System.out.println( i + ":" + items.get(i).getCaption()  );
		}
	}
	public void addItem( Item item ) {
		System.out.println( this.name + "は、"+ item.getCaption() + "を手に入れた");
		items.add(item);
	}
	/**
	 * この コマがアイテムを所持しているかを確認します。
	 * @return 書字している場合 true
	 */
	public boolean hasItems() {
		return items.size() > 0;
	}
	/**
	 * 指定された番号のアイテムを使用します
	 * @param coma アイテムの対象となる コマ
	 * @param id アイテム番号
	 */
	public void useItem( int id, Coma coma ) {
		if( id >= items.size() ) {
			return; //NG
		}
		if( id < 0) {
			return; //NG
		}
		
		Item target = items.get(id); 
		System.out.println( this.name + "は、"+ target.getCaption() + "を使用した");
		target.doUse(coma);
		items.remove(target); //使用するとなくなるよ
	}

}
