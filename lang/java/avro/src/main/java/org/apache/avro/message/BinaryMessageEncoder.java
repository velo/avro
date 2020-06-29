/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
<<<<<<< HEAD
 *   http://www.apache.org/licenses/LICENSE-2.0
=======
 *   https://www.apache.org/licenses/LICENSE-2.0
>>>>>>> 1.9.2
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.avro.message;

<<<<<<< HEAD
import com.google.common.primitives.Bytes;
=======
>>>>>>> 1.9.2
import org.apache.avro.AvroRuntimeException;
import org.apache.avro.Schema;
import org.apache.avro.SchemaNormalization;
import org.apache.avro.generic.GenericData;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;

/**
 * A {@link MessageEncoder} that adds a header and 8-byte schema fingerprint to
 * each datum encoded as binary.
 * <p>
 * This class is thread-safe.
 */
public class BinaryMessageEncoder<D> implements MessageEncoder<D> {

<<<<<<< HEAD
  static final byte[] V1_HEADER = new byte[] {(byte) 0xC3, (byte) 0x01};
=======
  static final byte[] V1_HEADER = new byte[] { (byte) 0xC3, (byte) 0x01 };
>>>>>>> 1.9.2

  private final RawMessageEncoder<D> writeCodec;

  /**
   * Creates a new {@link BinaryMessageEncoder} that uses the given
   * {@link GenericData data model} to deconstruct datum instances described by
   * the {@link Schema schema}.
   * <p>
<<<<<<< HEAD
   * Buffers returned by {@link #encode(D)} are copied and will not be modified
   * by future calls to {@code encode}.
   *
   * @param model the {@link GenericData data model} for datum instances
=======
   * Buffers returned by {@link #encode(D)} are copied and will not be modified by
   * future calls to {@code encode}.
   *
   * @param model  the {@link GenericData data model} for datum instances
>>>>>>> 1.9.2
   * @param schema the {@link Schema} for datum instances
   */
  public BinaryMessageEncoder(GenericData model, Schema schema) {
    this(model, schema, true);
  }

  /**
   * Creates a new {@link BinaryMessageEncoder} that uses the given
   * {@link GenericData data model} to deconstruct datum instances described by
   * the {@link Schema schema}.
   * <p>
   * If {@code shouldCopy} is true, then buffers returned by {@link #encode(D)}
   * are copied and will not be modified by future calls to {@code encode}.
   * <p>
<<<<<<< HEAD
   * If {@code shouldCopy} is false, then buffers returned by {@code encode}
   * wrap a thread-local buffer that can be reused by future calls to
   * {@code encode}, but may not be. Callers should only set {@code shouldCopy}
   * to false if the buffer will be copied before the current thread's next call
   * to {@code encode}.
   *
   * @param model the {@link GenericData data model} for datum instances
   * @param schema the {@link Schema} for datum instances
   * @param shouldCopy whether to copy buffers before returning encoded results
   */
  public BinaryMessageEncoder(GenericData model, Schema schema,
                              boolean shouldCopy) {
    this.writeCodec = new V1MessageEncoder<D>(model, schema, shouldCopy);
=======
   * If {@code shouldCopy} is false, then buffers returned by {@code encode} wrap
   * a thread-local buffer that can be reused by future calls to {@code encode},
   * but may not be. Callers should only set {@code shouldCopy} to false if the
   * buffer will be copied before the current thread's next call to
   * {@code encode}.
   *
   * @param model      the {@link GenericData data model} for datum instances
   * @param schema     the {@link Schema} for datum instances
   * @param shouldCopy whether to copy buffers before returning encoded results
   */
  public BinaryMessageEncoder(GenericData model, Schema schema, boolean shouldCopy) {
    this.writeCodec = new V1MessageEncoder<>(model, schema, shouldCopy);
>>>>>>> 1.9.2
  }

  @Override
  public ByteBuffer encode(D datum) throws IOException {
    return writeCodec.encode(datum);
  }

  @Override
  public void encode(D datum, OutputStream stream) throws IOException {
    writeCodec.encode(datum, stream);
  }

  /**
   * This is a RawDatumEncoder that adds the V1 header to the outgoing buffer.
<<<<<<< HEAD
   * BinaryDatumEncoder wraps this class to avoid confusion over what it does.
   * It should not have an "is a" relationship with RawDatumEncoder because it
   * adds the extra bytes.
=======
   * BinaryDatumEncoder wraps this class to avoid confusion over what it does. It
   * should not have an "is a" relationship with RawDatumEncoder because it adds
   * the extra bytes.
>>>>>>> 1.9.2
   */
  private static class V1MessageEncoder<D> extends RawMessageEncoder<D> {
    private final byte[] headerBytes;

    V1MessageEncoder(GenericData model, Schema schema, boolean shouldCopy) {
      super(model, schema, shouldCopy);
      this.headerBytes = getWriteHeader(schema);
    }

    @Override
    public void encode(D datum, OutputStream stream) throws IOException {
      stream.write(headerBytes);
      super.encode(datum, stream);
    }

    private static byte[] getWriteHeader(Schema schema) {
      try {
<<<<<<< HEAD
        byte[] fp = SchemaNormalization
            .parsingFingerprint("CRC-64-AVRO", schema);
        return Bytes.concat(V1_HEADER, fp);
=======
        byte[] fp = SchemaNormalization.parsingFingerprint("CRC-64-AVRO", schema);

        byte[] ret = new byte[V1_HEADER.length + fp.length];
        System.arraycopy(V1_HEADER, 0, ret, 0, V1_HEADER.length);
        System.arraycopy(fp, 0, ret, V1_HEADER.length, fp.length);
        return ret;
>>>>>>> 1.9.2
      } catch (NoSuchAlgorithmException e) {
        throw new AvroRuntimeException(e);
      }
    }
  }
}
