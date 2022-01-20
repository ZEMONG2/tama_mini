package controller;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;
import model.musicVO;


public class mp3Con {
	static MP3Player mp3 = new MP3Player();

	public static void main(String[] args) {

	}

	public static void Play(ArrayList<musicVO> List, int Index) {

		mp3.play(List.get(Index).getPath());

	}

	public static void Stop() {

		if (mp3.isPlaying()) {
			mp3.stop();
		}

	}

	
		
	}