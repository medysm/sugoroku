/**
 * 
 */
package sugoroku;

/**
 * もらえるマス の実装クラス
 * @author med
 *
 */
public class PresentCell extends Cell {

	/**
	 * コンストラクタ
	 */
	public PresentCell() {
	}

	@Override
	public boolean doEvent(Coma coma) {
		coma.addItem(new BoostItem() );
		return true;
	}

	@Override
	public String getCaption() {
		return "なにか見つけた！";
	}
	
	@Override
	public String getMark() {
		return "#";
	}

}
