package sugoroku;

/**
 * ゴールのセル クラス
 * @author hri
 */
public class GoalCell extends Cell {

	public GoalCell() {
	}

	@Override
	public boolean doEvent(Coma coma) {
		return false;
	}

	@Override
	public String getCaption() {
		return "アマゾンの奥地に到着した模様";
	}
	@Override
	public String getMark() {
		return "@";
	}

}
