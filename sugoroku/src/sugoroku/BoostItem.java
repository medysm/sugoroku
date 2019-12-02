package sugoroku;

/**
 * ジャンプアイテム
 * @author med
 *
 */
public class BoostItem extends Item {

	public BoostItem() {
		super("じゃんぷ装置");
	}

	@Override
	public boolean doUse(Coma coma) {
		System.out.println("一足飛びだっ！(1マス移動)");
		coma.proceed(1);
		return false;
	}

}
