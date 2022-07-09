package me.shrob;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static final Pattern patternBrackets = Pattern.compile("\\{#[0-9a-fA-F]{6}\\}");
    public static final Pattern pattern = Pattern.compile("#[0-9a-fA-F]{6}");

    public static String color(String s) {
        s = removeBrackets(s);
        Matcher match = pattern.matcher(s);
        while (match.find()) {
            String color = s.substring(match.start(), match.end());
            s = s.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
            match = pattern.matcher(s);
        }
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    private static String removeBrackets(String text) {
        Matcher m = patternBrackets.matcher(text);
        String replaced = text;
        while (m.find()) {
            String hexcode = m.group();
            String fixed = hexcode.substring(2, 8);
            replaced = replaced.replace(hexcode, "#" + fixed);
        }
        return replaced;
    }
}
