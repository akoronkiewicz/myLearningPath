package myLearningPath.OOP.file.music;

import myLearningPath.OOP.file.AbstractFile;
import myLearningPath.OOP.file.FileType;

public abstract class AbstractMusicFile extends AbstractFile implements MusicFile {

	protected String brandName;
	protected String title;

	public AbstractMusicFile(String name, int size, String bandName, String title) {
		super(name, size);
		this.brandName = bandName;
		this.title = title;
	}

	@Override
	public FileType getType() {
		return FileType.MUSIC;
	}
}
