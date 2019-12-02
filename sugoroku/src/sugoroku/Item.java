package sugoroku;

/**
 * すごろく の チートアイテム
 * @author med
 */
public abstract class Item {

	/**
	 * アイテムの名称
	 */
	private String caption;
	
	/**
	 * コンストラクタ
	 * @param caption 表示名称
	 */
	protected Item(String caption) {
		this.caption = caption;
	}
	/**
	 * 使用する際に呼び出されます
	 * @param coma 対象となるコマ
	 * @return 結果(どうするかは未定)
	 */
	public abstract boolean doUse( Coma coma );
	/**
	 * アイテム名称を取得します
	 * @return アイテム名称文字列
	 */
	public String getCaption() {
		return this.caption;
	}

}
