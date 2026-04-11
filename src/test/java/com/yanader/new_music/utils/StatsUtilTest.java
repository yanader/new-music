package com.yanader.new_music.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatsUtilTest {

    List<Integer> emptyList;
    List<Integer> oneItemList;
    List<Integer> identicalList;
    List<Integer> oddLengthList;
    List<Integer> evenLengthList;
    List<Integer> normalListOne;
    List<Integer> normalListTwo;
    List<Integer> normalListThree;


    @BeforeEach
    void setup() {
        emptyList = new ArrayList<>();
        oneItemList = new ArrayList<>(List.of(1));
        identicalList = new ArrayList<>(List.of(1,1,1,1,1));
        oddLengthList = new ArrayList<>(List.of(1,3,9,9,10));
        evenLengthList = new ArrayList<>(List.of(1,3,9,9,10,10));
        normalListOne = new ArrayList<>(List.of(1,2,2,4,5));
        normalListTwo = new ArrayList<>(List.of(1,4,7,9,9));
        normalListThree = new ArrayList<>(List.of(3,3,5,8,10));
    }

    @Test
    void shouldCalculateMean(){
        assertEquals(1.0 , StatsUtil.mean(oneItemList));
        assertEquals(1.0 , StatsUtil.mean(identicalList));
        assertEquals(6.4, StatsUtil.mean(oddLengthList));
        assertEquals(7.0, StatsUtil.mean(evenLengthList));
        assertEquals(2.8, StatsUtil.mean(normalListOne));
        assertEquals(6.0, StatsUtil.mean(normalListTwo));
        assertEquals(5.8, StatsUtil.mean(normalListThree));
    }

    @Test
    void shouldReturnMeanZeroFromEmptyList(){
        assertEquals(0.0, StatsUtil.mean(emptyList));
    }

    @Test
    void shouldCalculateMedian(){
        assertEquals(1.0 , StatsUtil.median(oneItemList));
        assertEquals(1.0 , StatsUtil.median(identicalList));
        assertEquals(9.0, StatsUtil.median(oddLengthList));
        assertEquals(9.0, StatsUtil.median(evenLengthList));
        assertEquals(2.0, StatsUtil.median(normalListOne));
        assertEquals(7.0, StatsUtil.median(normalListTwo));
        assertEquals(5.0, StatsUtil.median(normalListThree));
    }

    @Test
    void shouldReturnMedianZeroFromEmptyList(){
        assertEquals(0.0, StatsUtil.mean(emptyList));
    }

    @Test
    void shouldCalculateMode(){
        assertEquals(1 , StatsUtil.mode(oneItemList));
        assertEquals(1 , StatsUtil.mode(identicalList));
        assertEquals(9, StatsUtil.mode(oddLengthList));
        assertEquals(9, StatsUtil.mode(evenLengthList));
        assertEquals(2, StatsUtil.mode(normalListOne));
        assertEquals(9, StatsUtil.mode(normalListTwo));
        assertEquals(3, StatsUtil.mode(normalListThree));
    }

    @Test
    void shouldReturnModeNullFromEmptyList(){
        assertNull(StatsUtil.mode(emptyList));
    }

    @Test
    void shouldCalculateStdDev(){
        assertEquals(0.0, StatsUtil.stdDev(identicalList));
        assertEquals(4.09878030638384, StatsUtil.stdDev(oddLengthList));
        assertEquals(3.9496835316262997, StatsUtil.stdDev(evenLengthList));
        assertEquals(1.6431676725154984, StatsUtil.stdDev(normalListOne));
        assertEquals(3.4641016151377544, StatsUtil.stdDev(normalListTwo));
        assertEquals(3.1144823004794873, StatsUtil.stdDev(normalListThree));
    }

    @Test
    void shouldReturnStdDevNullFromEmptyOrOneItemList(){
        assertNull(StatsUtil.stdDev(emptyList));
        assertNull(StatsUtil.stdDev(oneItemList));
    }
}