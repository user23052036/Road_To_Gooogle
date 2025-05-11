//explanation in copy

//brute-force
//TC-> O(MN(M+N)+MN) ~ O(N^3)
//SC-> O(1)
#include<bits/stdc++.h>
using namespace std;

class Solution1 
{
public:
    void setZeroes(vector<vector<int>>& matrix) 
    {
        int row = matrix.size();
        int col = matrix[0].size();

        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(matrix[i][j] == 0)
                    setRowCol(matrix,i,j);
            }
        }   

        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }   
    }
private:
    void setRowCol(vector<vector<int>>&matrix, int zero_row, int zero_col)
    {
        int row = matrix.size();
        int col = matrix[0].size();

        for(int i=0; i<col; i++)
            if(matrix[zero_row][i] != 0) matrix[zero_row][i] = -1;

        for(int i=0; i<row; i++)
            if(matrix[i][zero_col] != 0) matrix[i][zero_col] = -1;
    }
};

//better solution still brute force
//TC-> O(2NM)
//SC-> O(M+N)

class Solution2 
{
    public:
        void setZeroes(vector<vector<int>>& matrix) 
        {
            int row = matrix.size();
            int col = matrix[0].size();
    
            vector<int>row_matrix(row);
            fill(row_matrix.begin(),row_matrix.end(),0);
            vector<int>col_matrix(col);
            fill(col_matrix.begin(),col_matrix.end(),0);
    
            for(int i=0; i<row; i++)
            {
                for(int j=0; j<col; j++)
                {
                    if(matrix[i][j] == 0)
                    {
                        row_matrix[i]=1;
                        col_matrix[j]=1;
                    }
                }
            }
            for(int i=0; i<row; i++)
            {
                for(int j=0; j<col; j++)
                {
                    if(row_matrix[i]==1 || col_matrix[j]==1)
                        matrix[i][j]=0;
                }
            }
        }
    };

//OPTIMAL SOLUTION
//TC->O(MN+MN)
//SC->O(1)

class Solution3 
{
    public:
        void setZeroes(vector<vector<int>>& matrix) 
        {
            int row = matrix.size();// ---> matrix[...][0]
            int col = matrix[0].size();// ----> matrix[0][...]
    
            // vector<int>row_matrix(row);
            // fill(row_matrix.begin(),row_matrix.end(),0);
            // vector<int>col_matrix(col);
            // fill(col_matrix.begin(),col_matrix.end(),0);
    
            int col0=1;
    
            //marking 0 in the buffer in full iteration
            for(int i=0; i<row; i++)
            {
                for(int j=0; j<col; j++)
                {
                    if(matrix[i][j] == 0)
                    {
                        matrix[i][0]=0;//set in row buffer
    
                        if(j!=0) matrix[0][j]=0;//set in col buffer
                        else col0=0;
                    }
                }
            }
    
            //use the buffer to mark 0 in the smaller (reduced matrix)
            for(int i=1; i<row; i++)
                for(int j=1; j<col; j++)
                    if(matrix[i][j] != 0)
                        if(matrix[i][0] == 0 || matrix[0][j] == 0)
                            matrix[i][j]=0;
    
            //edge cases for the buffer row and column in the matrix 
            if(matrix[0][0] == 0)
                for(int j=0; j<col; j++)
                    matrix[0][j]=0;           
            if(col0 == 0)
                for(int i=0; i<row; i++)
                    matrix[i][0]=0;
        }
    };