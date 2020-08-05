package edu.tacoma.uw.jasonli7.team12project.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/**
 * Team 12 Group project.
 *
 * @author Daniel Stocksett.
 *
 * @version 2nd Aug 2020.
 *
 * A class for creating dummy data.
 */
public class DeviceContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Device> ITEMS = new ArrayList<Device>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Device> ITEM_MAP = new HashMap<String, Device>();

    public static final List<Review> mReviews = new ArrayList<Review>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDeviceItem(i));
        }
    }

    private static void addItem(Device item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getDeviceName(), item);
    }

    private static Device createDeviceItem(int position) {
        loadReviews();
        return new Device("Device: " + String.valueOf(position), mReviews);
    }

    private static void loadReviews() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {

            if (i % 3 == 0) {
                sb.append("\n");
            }
            sb.append("Review ");
        }
        Random q = new Random();

        for (int j = 0; j < 25; j++) {
            double p = q.nextDouble() * 5;
            Review r = new Review(j+"@"+j, sb.toString(), p);
            mReviews.add(r);
        }
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Device: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DeviceItem {
        public final String id;
        public final String content;
        public final String details;

        public DeviceItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}