package dev.foxikle.castlesiege.managers;

import com.xxmicloxx.NoteBlockAPI.model.FadeType;
import com.xxmicloxx.NoteBlockAPI.model.RepeatMode;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.model.playmode.MonoStereoMode;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import dev.foxikle.castlesiege.CastleSiege;

import java.io.File;

public class MusicManager {
    private final CastleSiege plugin;
    public MusicManager(CastleSiege plugin) {
        this.plugin = plugin;
    }

    public RadioSongPlayer globalPlayer;

    public void setup(String songName) {
        File file = new File("plugins/CastleSiege/songs/" + songName);
        if(file.exists()) {
            Song song = NBSDecoder.parse(file);
            globalPlayer = new RadioSongPlayer(song);
            globalPlayer.setChannelMode(new MonoStereoMode());
            globalPlayer.getFadeIn().setFadeDuration(30);
            globalPlayer.getFadeIn().setType(FadeType.LINEAR);
            globalPlayer.getFadeOut().setFadeDuration(30);
            globalPlayer.getFadeOut().setType(FadeType.LINEAR);
            globalPlayer.setRepeatMode(RepeatMode.ALL);
            globalPlayer.setPlaying(true);
        } else {
            plugin.getLogger().severe("Song file not found!");
        }
    }

    public RadioSongPlayer getGlobalPlayer() {
        return globalPlayer;
    }
}
