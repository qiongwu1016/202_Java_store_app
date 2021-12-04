package com.store.app;

// Basic validation interface
public abstract class Handler {
    private Handler next;

    /**
     * Builds chains of handler objects.
     */
    public Handler linkWith(Handler next) {
        this.next = next;
        return next;
    }

    /**
     * Subclasses will implement this method with concrete validates.
     */
    public abstract Boolean validate();

    protected Boolean validateNext() {
        if (next == null) {
            return true;
        }
        return next.validate();
    }
}
