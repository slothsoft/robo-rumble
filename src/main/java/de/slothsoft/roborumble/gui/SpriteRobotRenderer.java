package de.slothsoft.roborumble.gui;

import java.awt.Graphics;
import java.awt.Image;

import de.slothsoft.roborumble.Direction;

public class SpriteRobotRenderer implements RobotRenderer {

	private static final long FRAME_TIME = 1000 / 24; // 24 frames per second

	private final Image spriteImage;
	private final int frames;
	private final int frameWidth;
	private final int frameHeight;

	private int currentFrame;
	private long lastTime;

	public SpriteRobotRenderer(Image spriteImage, int frames) {
		this.spriteImage = spriteImage;
		this.frames = frames;

		this.frameWidth = spriteImage.getWidth(null) / frames;
		this.frameHeight = spriteImage.getHeight(null) / 4;
	}

	@Override
	public void paint(Graphics graphics, Direction direction) {
		long currentTime = System.currentTimeMillis();
		if (currentTime - this.lastTime >= FRAME_TIME) {
			this.currentFrame = (int) ((this.currentFrame + (currentTime - this.lastTime) / FRAME_TIME) % this.frames);
			this.lastTime = currentTime;
		}
		int x = this.currentFrame * this.frameWidth;
		int y = direction.ordinal() * this.frameHeight;

		graphics.drawImage(this.spriteImage, 0, 0, Tile.WIDTH_IN_PIXELS, Tile.HEIGHT_IN_PIXELS, x, y,
				x + this.frameWidth, y + this.frameHeight, null);
	}

}
