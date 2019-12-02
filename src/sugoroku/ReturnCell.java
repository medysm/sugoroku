/**
 * 
 */
package sugoroku;

/**
 * 戻されて悲しい マス目
 * @author med
 */
public class ReturnCell extends Cell {

	/**
	 * このマスで撤退するコマ数(怖さ)
	 */
	private int amount;
	/**
	 * コンストラクタ 
	 * @param amount 戻る量
	 */
	public ReturnCell( int amount ) {
		this.amount = amount;
	}

	@Override
	public boolean doEvent(Coma coma) {
		System.out.println("危険なので"+ amount +"マス戻ろう…");
		coma.proceed( -amount ); //戻されるよ…。
		return true;
	}

	@Override
	public String getCaption() {
		return "ピラニアの居る川に差しかかった。危ないっ";
	}
	@Override
	public String getMark() {
		return "<";
	}

}
