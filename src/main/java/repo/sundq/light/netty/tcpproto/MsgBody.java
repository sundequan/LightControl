package repo.sundq.light.netty.tcpproto;

import io.netty.buffer.ByteBuf;

public interface MsgBody {
	public void encode(ByteBuf dst);
	public void decode(ByteBuf src);
}
