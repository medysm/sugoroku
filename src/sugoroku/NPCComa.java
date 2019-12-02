package sugoroku;

/**
 * NPC専用コマ
 * @author med
 */
public class NPCComa extends Coma {

	/**
	 * 連番用
	 */
	private static int count;
	/**
	 * コンストラクタ
	 */
	public NPCComa() {
		super("[CPU" + count + "]");
		count++;
	}
	@Override
	public boolean isAuto() {
		return true;
	}

}
