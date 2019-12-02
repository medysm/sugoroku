package sugoroku;

public class UserComa extends Coma {

	public UserComa(String name) {
		super( name );
	}
	@Override
	public boolean isAuto() {
		return false;
	}

}
