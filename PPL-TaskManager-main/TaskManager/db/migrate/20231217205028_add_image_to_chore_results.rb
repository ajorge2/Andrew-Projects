class AddImageToChoreResults < ActiveRecord::Migration[7.1]
  def change
    add_column :chore_results, :image, :string
  end
end
