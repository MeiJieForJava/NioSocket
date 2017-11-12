package com.jd.nio.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2017/11/11
 * Time : 15:33
 */
public class Client {

    private static Logger logger = LoggerFactory.getLogger(Client.class);

    private static final int port = 10000;

    private SocketChannel socketChannel;

    public Client() {
        try {
            socketChannel = SocketChannel.open();
            InetAddress host = InetAddress.getLocalHost();
            InetSocketAddress address = new InetSocketAddress(host, port);

            socketChannel.connect(address);

            logger.debug("***");
            logger.debug("client ip:" + socketChannel.socket().getLocalAddress());
            logger.debug("client port:" + socketChannel.socket().getLocalPort());
            logger.debug("server ip:" + socketChannel.socket().getInetAddress());
            logger.debug("server port:" + socketChannel.socket().getPort());
            logger.debug("***");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Cilent socket establish failed!");
        }
        logger.error("Cilent socket establish success!");
    }

    public void request(String request)  {
    }
}
