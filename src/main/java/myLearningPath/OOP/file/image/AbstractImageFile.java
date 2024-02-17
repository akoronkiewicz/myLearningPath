package myLearningPath.OOP.file.image;

import myLearningPath.OOP.file.AbstractFile;
import myLearningPath.OOP.file.FileType;

public class AbstractImageFile extends AbstractFile {
	public AbstractImageFile(String name, int size) {
		super(name, size);
	}

	@Override
	public FileType getType() {
		return FileType.IMAGE;
	}
}
