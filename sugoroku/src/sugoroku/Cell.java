/**
 * 
 */
package sugoroku;

/**
 * すごろくに使用される マス目を表現する 抽象基底クラス
 * @author med
 */
public abstract class Cell {
	/**
	 * コンストラクタ(new できないので protected にしておく)
	 */
	protected Cell() {
	}
	/**
	 * なにかしらのイベントを実行できる予定
	 * @param coma イベントの対象となる コマ
	 * @return イベント処理の結果何かが変わるかどうか の情報を返す予定
	 */
	public abstract boolean doEvent( Coma coma );
	/**
	 * このマス目の表示名
	 * @return 表示文字列
	 */
	public abstract String getCaption();
	/**
	 * このマス目のイメージ文字
	 * @return イメージ文字
	 */
	public abstract String getMark();

}
