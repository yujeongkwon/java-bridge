package bridge.controller;

import bridge.service.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.service.BridgeService;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    User user = new User();
    Bridge bridge;

    public void initGame(String size){
        int bridgeLength = BridgeService.validateBridgeLength(size);

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> resultBridge = bridgeMaker.makeBridge(bridgeLength);

        bridge = new Bridge(bridgeLength,resultBridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String move,int idx) {
        BridgeService.validateMove(move);
        boolean isSuccess = BridgeService.movingResult(move,bridge.getResultBridge().get(idx));

        user.updateMapBridge(move,isSuccess);

        return isSuccess;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
