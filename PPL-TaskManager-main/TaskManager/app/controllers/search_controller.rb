class SearchController < ApplicationController
  def index
    @foundChores = ChoreResult.all
  end
  def chore_result_params
    @search = Chore.find(params[:id])
    params.require(:chore_result).permit(:image)
  end
end
