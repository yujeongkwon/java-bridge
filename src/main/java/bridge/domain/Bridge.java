package bridge.domain;

import bridge.exception.BridgeException;

import java.util.List;

public class Bridge {
    private static int bridgeLength;
    private static List<String> resultBridge;

    public Bridge(int bridgeLength, List<String> resultBridge){
        Bridge.bridgeLength = bridgeLength;
        Bridge.resultBridge = resultBridge;
    }

    public int getBridgeLength() {
        return bridgeLength;
    }

    public List<String> getResultBridge() {
        return resultBridge;
    }
}
