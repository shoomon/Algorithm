#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

static int get_row(int num, int w){
    return (num-1)/w;
}

static int get_col(int num, int w){
    int row = (num-1)/w;
    
    if(row%2 == 0){
        return (num-1)%w;
    }else{
        return w-(num-1)%w-1;
    }
}

int solution(int n, int w, int num) {
    int answer;
    
    int last_row = get_row(n,w);
    int last_col = get_col(n,w);
    
    int target_row = get_row(num,w);
    int target_col = get_col(num,w);
    
    answer = last_row - target_row;
    
    if(last_row%2 == 0){
        if(last_col >= target_col) answer++;
    }else{
        if(last_col <= target_col) answer++;
    }
    
    return answer;
}