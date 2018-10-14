package Model.user;

public class Manager implements Role{
	private Manager m;
	@Override
	public Manager getRole() {
		return m;
	}

	public Manager() {

	}

}
