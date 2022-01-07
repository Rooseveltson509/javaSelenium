package fr.zenity.academy.Enum;

public enum Device {

    WINDOWS(-1, -1, true),
    IPHONE(1, 1, false);

    public final int width;
    public final int length;
    public final boolean isReal;

    Device(int width, int length, boolean isReal){
        this.width = width;
        this.length = length;
        this.isReal = isReal;
    }

}