/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.trevni;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.junit.Test;

public class TestBZip2Codec {

  @Test
  public void testBZip2CompressionAndDecompression() throws IOException {

    MetaData meta = new MetaData();
    meta.setCodec("bzip2");
    Codec codec = Codec.get(meta);

<<<<<<< HEAD
    //Confirm that the right codec Came back
    assertTrue(codec instanceof BZip2Codec);

    //This is 3 times the byte buffer on the BZip2 decompress plus some extra
=======
    // Confirm that the right codec Came back
    assertTrue(codec instanceof BZip2Codec);

    // This is 3 times the byte buffer on the BZip2 decompress plus some extra
>>>>>>> 1.9.2
    final int inputByteSize = BZip2Codec.DEFAULT_BUFFER_SIZE * 3 + 42;

    byte[] inputByteArray = new byte[inputByteSize];

<<<<<<< HEAD
    //Generate something that will compress well
=======
    // Generate something that will compress well
>>>>>>> 1.9.2
    for (int i = 0; i < inputByteSize; i++) {
      inputByteArray[i] = (byte) (65 + i % 10);
    }

    ByteBuffer inputByteBuffer = ByteBuffer.wrap(inputByteArray);

    ByteBuffer compressedBuffer = codec.compress(inputByteBuffer);

<<<<<<< HEAD
    //Make sure something returned
=======
    // Make sure something returned
>>>>>>> 1.9.2
    assertTrue(compressedBuffer.array().length > 0);
    // Make sure the compressed output is smaller then the original
    assertTrue(compressedBuffer.array().length < inputByteArray.length);

    ByteBuffer decompressedBuffer = codec.decompress(compressedBuffer);

<<<<<<< HEAD
    //The original array should be the same length as the decompressed array
    assertTrue(decompressedBuffer.array().length == inputByteArray.length);

    //Every byte in the outputByteArray should equal every byte in the input array
=======
    // The original array should be the same length as the decompressed array
    assertTrue(decompressedBuffer.array().length == inputByteArray.length);

    // Every byte in the outputByteArray should equal every byte in the input array
>>>>>>> 1.9.2
    byte[] outputByteArray = decompressedBuffer.array();
    System.arraycopy(outputByteArray, 0, inputByteArray, 0, inputByteSize);
  }
}
