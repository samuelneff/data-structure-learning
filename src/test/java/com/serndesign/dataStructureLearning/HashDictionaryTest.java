package com.serndesign.dataStructureLearning;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;

public class HashDictionaryTest {

    @Test
    public void emptyGet() {
        HashDictionary<String, String> hash = new HashDictionary<>();
        assertThat(hash.get("a"), nullValue());
    }

    @Test
    public void putGetA() {
        HashDictionary<String, String> hash = new HashDictionary<>();
        hash.put("a", "A");
        String actual = hash.get("a");
        assertThat(actual, equalTo("A"));
    }

    @Test
    public void putGetAbc() {
        HashDictionary<String, String> hash = new HashDictionary<>();
        hash.put("a", "A");
        hash.put("b", "B");
        hash.put("c", "C");
        assertThat(hash.get("a"), equalTo("A"));
        assertThat(hash.get("b"), equalTo("B"));
        assertThat(hash.get("c"), equalTo("C"));
        assertThat(hash.get("d"), nullValue());
    }

    @Test
    public void putPutOverride() {
        HashDictionary<String, String> hash = new HashDictionary<>();
        hash.put("a", "A");
        hash.put("b", "B");
        hash.put("c", "C");

        hash.put("b", "BBB");
        hash.put("c", "CCC");

        assertThat(hash.get("a"), equalTo("A"));
        assertThat(hash.get("b"), equalTo("BBB"));
        assertThat(hash.get("c"), equalTo("CCC"));
        assertThat(hash.get("d"), nullValue());
    }
}