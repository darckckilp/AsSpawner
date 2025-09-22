package astralcraft.astralcraftspawner.configs;

import net.elytrium.serializer.annotations.Comment;
import net.elytrium.serializer.annotations.CommentValue;
import net.elytrium.serializer.language.object.YamlSerializable;

import astralcraft.astralcraftspawner.Astralcraftspawner;

public class mainConfig extends YamlSerializable {

    @Comment(
                @CommentValue(" Какой предмет нужен для получения спавнера")
    )
    public String item = "diamond";

    @Comment(
                @CommentValue(" Звук после получения спавнера")
    )
    public String sound = "block.amethyst_block.break";

    public void reloadConfig() {
        reload(Astralcraftspawner.getInstance().mainConfigFile.toPath());
    }
}
