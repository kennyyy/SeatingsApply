package com.sa.roomset.service;

import com.sa.roomset.model.RoomSetVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RoomSetServiceIf {

    public RoomSetVO createRoom(HttpServletRequest request, HttpServletResponse response);

    public RoomSetVO insertRoom(RoomSetVO RVO);

    public void insertSeat (HttpServletRequest request, HttpServletResponse response);

}
