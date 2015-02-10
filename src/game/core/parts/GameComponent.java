package game.core.parts;

public abstract interface GameComponent {

	public abstract void init();

	public abstract void update();

	public abstract void render();

	public abstract void mouseClicked(int button, int x, int y, int clickCount);

	public abstract void mousePressed(int button, int x, int y);

}