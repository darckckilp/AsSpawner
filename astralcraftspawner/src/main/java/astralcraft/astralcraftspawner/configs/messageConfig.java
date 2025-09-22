package astralcraft.astralcraftspawner.configs;

import net.elytrium.serializer.annotations.Comment;
import net.elytrium.serializer.annotations.CommentValue;
import net.elytrium.serializer.language.object.YamlSerializable;

import astralcraft.astralcraftspawner.Astralcraftspawner;

public class messageConfig extends YamlSerializable {

    @Comment({
            @CommentValue(" "),
            @CommentValue(" Сообщение если у игрока нет разрешения"),
            @CommentValue(" ")
    })
    public String permission = "§cу вас нет разрешения.";
    @Comment({
            @CommentValue(" Сообщение после перезагрузки плагина"),
            @CommentValue(" ")
    })
    public String reload_complite = "§cПлагин перезагружен!";
    @Comment({
            @CommentValue(" Сообщение при неизвестной команде"),
            @CommentValue(" ")
    })
    public String idkwhatthis = "§cНе известная команда ";
    @Comment({
            @CommentValue(" Не верная команда"),
            @CommentValue(" ")
    })
    public String reload = "§cИспользование:";

    public void reloadConfig() {
        reload(Astralcraftspawner.getInstance().messageConfigFile.toPath());
    }
}
