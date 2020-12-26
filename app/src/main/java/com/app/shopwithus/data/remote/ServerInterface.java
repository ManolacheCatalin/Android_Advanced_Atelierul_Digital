package com.app.shopwithus.data.remote;

import java.util.List;

public interface ServerInterface<T> {
    List<T> getItems();

}
