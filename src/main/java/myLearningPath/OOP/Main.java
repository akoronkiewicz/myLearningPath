package myLearningPath.OOP;

import myLearningPath.OOP.drive.Drive;
import myLearningPath.OOP.drive.SSDDrive;
import myLearningPath.OOP.file.File;
import myLearningPath.OOP.file.image.GIFImageFile;
import myLearningPath.OOP.file.image.JPGImageFile;
import myLearningPath.OOP.file.music.MP3File;

public class Main {
	public static void main(String[] args) {

		Monitor monitor = new Monitor("Dell");
//		HDDDrive hddDrive = new HDDDrive();
//
////		System.out.println(monitor.getResolution());
////		monitor.setLowResolution();
////		System.out.println(monitor.getResolution());
//
//		Computer computer = new Computer(monitor, hddDrive);
////		hddDrive.addFile(new File("photo.jpg"));
////		hddDrive.listFiles();
//		//computer.addFile(new File("file.png"));
//		computer.listFiles();
//
//		Mouse mouse = new Mouse("Mouse");
//		MemoryStick memoryStick = new MemoryStick("pendrive");
//
//		computer.addUSBDevice(mouse);
//		computer.addUSBDevice(memoryStick);
//
//		computer.removeUSBDevice(mouse);
//
//		memoryStick.eject();
//		computer.removeUSBDevice(memoryStick);
//
//		List<USBDevice> usbDevices = computer.getUsbDevices();
//
//		for (USBDevice usbDevice : usbDevices) {
//			System.out.println(usbDevice.getName());
//		}

		MP3File mp3File = new MP3File("audio.mp3", 4000, "tak", "Sonne", 100);

		GIFImageFile gifImageFile = new GIFImageFile("funnydog.gif", 150);

		JPGImageFile jpgImageFile = new JPGImageFile("holidays.jpg", 400, 80);

		Drive ssdDrive = new SSDDrive();

		Computer computer = new Computer(monitor, ssdDrive);
		computer.addFile(mp3File);
		computer.addFile(gifImageFile);
		computer.addFile(jpgImageFile);
		computer.listFiles();

		File file = computer.findFile("audio.mp3");
		System.out.println(file.getSize());
		System.out.println(file);
	}
}
