package com.ktp.loglib;

import static com.ktp.loglib.StackTraceIndices.CUSTOM_TAG_TREE_INDEX;

import android.util.Log;

import java.util.Set;

import timber.log.Timber;

public class CustomTagTree extends Timber.DebugTree {
    private Set<String> allowedTags;

    public CustomTagTree(Set<String> allowedTags) {
        this.allowedTags = allowedTags;
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        // Automatically set the tag based on the stack trace element
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String customTag = createStackElementTag(stackTrace[CUSTOM_TAG_TREE_INDEX]);
        String originalTag = extractOriginalTag(customTag);

        if (allowedTags.contains(originalTag)) {
            super.log(priority, customTag, message, t);
        } else {
            // For debugging purposes: log a message when a tag is not allowed
             System.out.println("Tag not allowed: " + originalTag);
        }
    }

    private String extractOriginalTag(String customTag) {
        // Extract the original tag from the custom tag
        // Assuming the original tag is the part before the first colon
        int colonIndex = customTag.indexOf(":");
        if (colonIndex != -1) {
            return customTag.substring(0, colonIndex);
        }
        return customTag;
    }

}

