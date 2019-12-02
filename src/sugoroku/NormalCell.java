/**
 * 
 */
package sugoroku;

/**
 * ふつうなマス の実装クラス
 * @author med
 *
 */
public class NormalCell extends Cell {

	/**
	 * コンストラクタ
	 */
	public NormalCell() {
	}

	@Override
	public boolean doEvent(Coma coma) {
		coma.addPoint(100);
		return true;
	}

	@Override
	public String getCaption() {
		return "風が吹いている……";
	}
	
	@Override
	public String getMark() {
		return "~";
	}

}
