package sugoroku;

public class StartCell extends Cell {

	public StartCell() {
	}

	@Override
	public boolean doEvent(Coma coma) {
		return true;
	}

	@Override
	public String getCaption() {
		return "ここを我々のベースキャンプとする";
	}
	
	@Override
	public String getMark() {
		return "$";
	}

}
