package user;

public class Manager implements Role{
	private Manager m = new Manager();
	@Override
	public Manager getRole() {
		return m;
	}



}
