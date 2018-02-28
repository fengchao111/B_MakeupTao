package alipay.demo.trade.model.hb;

import com.alipay.demo.trade.model.hb.PosTradeInfo;
import com.alipay.demo.trade.model.hb.TradeInfo;
import com.alipay.demo.trade.utils.Utils;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by liuyangkly on 15/9/28.
 */
public class TradeInfoAdapter implements JsonSerializer<List<com.alipay.demo.trade.model.hb.TradeInfo>> {
    @Override
    public JsonElement serialize(List<com.alipay.demo.trade.model.hb.TradeInfo> tradeInfoList, Type type, JsonSerializationContext jsonSerializationContext) {
        if (Utils.isListEmpty(tradeInfoList)) {
            return null;
        }

        TradeInfo tradeInfo = tradeInfoList.get(0);
        if (tradeInfo instanceof PosTradeInfo) {
            return new JsonPrimitive(StringUtils.join(tradeInfoList, ""));
        }

        return jsonSerializationContext.serialize(tradeInfoList);
    }
}
